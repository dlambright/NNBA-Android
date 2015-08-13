package com.example.charliebuckets.nnba_android.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.IntegerRes;
import android.util.LruCache;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by charliebuckets on 8/12/15.
 *
 * TODO: Reimplement this class to remove memory leak of LruCache object. Bound to activity lifecycle
 * TODO: Ensure LruCache object size isn't greater than available memory class of device
 *          http://stackoverflow.com/questions/11623994/example-using-androids-lrucache/11624281#11624281
 */
public class ImageUtility {
    public static final int TEAM_LOGO_TODAYS_GAMES_WIDTH = 120;
    public static final int TEAM_LOGO_TODAYS_GAMES_HEIGHT = 120;
    private static final int LRU_CACHE_SIZE =
            32*ImageUtility.TEAM_LOGO_TODAYS_GAMES_HEIGHT*ImageUtility.TEAM_LOGO_TODAYS_GAMES_WIDTH*30;

    private static LruCache<Integer, Bitmap> logo_cache = null;

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(final Resources res, final int resId,
                                                         final int reqWidth, final int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static Observable<Bitmap> getScaledImageObservableFromDrawable(final Resources res, @IntegerRes final int resId,
                                                                          final int reqWidth, final int reqHeight) {
        return Observable.defer(new Func0<Observable<Bitmap>>() {
            @Override
            public Observable<Bitmap> call() {
                return Observable.just(decodeSampledBitmapFromResource(res, resId, reqWidth, reqHeight))
                        .doOnNext(new Action1<Bitmap>() {
                                    @Override
                                    public void call(Bitmap bitmap) {
                                    logo_cache.put(resId, bitmap);
                                }
                            }
                        );
            }
        });
    }

    public static Observable<Bitmap> getScaledImageObservableFromCache(@IntegerRes int resId){
        // if we had access to memory class of device:
        // if (memClass < logo_cache) logo_cache = ....(memClass)
        // else
        if (logo_cache == null) {
            logo_cache = new LruCache<>(LRU_CACHE_SIZE);
        }
        return Observable.just(logo_cache.get(resId))
                .filter(new Func1<Bitmap, Boolean>() {
                    @Override
                    public Boolean call(Bitmap bitmap) {
                        return bitmap != null;
                    }
                });
    }

    public static Observable<Bitmap> getTeamLogoObservable(final Resources res, @IntegerRes final int teamResId,
                                                           final int reqWidth, final int reqHeight) {
        return Observable
                .concat(getScaledImageObservableFromCache(teamResId),
                        getScaledImageObservableFromDrawable(
                                res,
                                teamResId,
                                reqWidth,
                                reqHeight)
                )
                .takeFirst(new Func1<Bitmap, Boolean>() {
                    @Override
                    public Boolean call(Bitmap bitmap) {
                        return bitmap != null;
                    }
                });
    }
}
