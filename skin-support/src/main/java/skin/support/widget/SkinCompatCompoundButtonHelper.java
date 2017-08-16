package skin.support.widget;

import android.content.res.TypedArray;
import android.support.v4.widget.CompoundButtonCompat;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import skin.support.R;
import skin.support.content.res.SkinCompatResources;

/**
 * Created by ximsfei on 17-1-14.
 */
public class SkinCompatCompoundButtonHelper extends SkinCompatHelper {
    private final CompoundButton mView;
    private int mButtonResourceId = INVALID_ID;
    private int mButtonTintResId = INVALID_ID;

    public SkinCompatCompoundButtonHelper(CompoundButton view) {
        mView = view;
    }

    void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = mView.getContext().obtainStyledAttributes(attrs, R.styleable.CompoundButton,
                defStyleAttr, INVALID_ID);
        try {
            if (a.hasValue(R.styleable.CompoundButton_android_button)) {
                mButtonResourceId = a.getResourceId(
                        R.styleable.CompoundButton_android_button, INVALID_ID);
            }
//                if (resourceId != 0) {
//                    mView.setButtonDrawable(
//                            AppCompatResources.getDrawable(mView.getContext(), resourceId));
//                }
//            }
            if (a.hasValue(R.styleable.CompoundButton_buttonTint)) {
                mButtonTintResId = a.getResourceId(R.styleable.CompoundButton_buttonTint, INVALID_ID);
            }
//            if (a.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
//                CompoundButtonCompat.setButtonTintMode(mView,
//                        DrawableUtils.parseTintMode(
//                                a.getInt(R.styleable.CompoundButton_buttonTintMode, -1),
//                                null));
//            }
        } finally {
            a.recycle();
        }
        applySkin();
    }

    public void setButtonDrawable(int resId) {
        mButtonResourceId = resId;
        applySkin();
    }

    @Override
    public void applySkin() {
        mButtonResourceId = SkinCompatHelper.checkResourceId(mButtonResourceId);
        if (mButtonResourceId != INVALID_ID) {
            mView.setButtonDrawable(SkinCompatResources.getInstance().getDrawable(mButtonResourceId));
        }
        mButtonTintResId = SkinCompatHelper.checkResourceId(mButtonTintResId);
        if (mButtonTintResId != INVALID_ID) {
            CompoundButtonCompat.setButtonTintList(mView, SkinCompatResources.getInstance().getColorStateList(mButtonTintResId));
        }
    }
}
