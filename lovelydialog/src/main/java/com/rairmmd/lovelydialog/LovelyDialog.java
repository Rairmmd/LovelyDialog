package com.rairmmd.lovelydialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Rair
 * @date 2018/12/27
 * <p>
 * desc:
 */
public class LovelyDialog {

    private String mTitle;
    private String mContent;
    private String mPositiveText;
    private String mNegativeText;
    private Context mContext;
    @DrawableRes
    private int mIcon;
    @ColorInt
    private int mPositiveColor;
    @ColorInt
    private int mNegativeColor;
    @ColorInt
    private int mBarColor;
    private Animation mAnimation;
    private Icon mVisible;
    private boolean mCancelable;

    private LovelyDialogCallback mPositiveCallback;
    private LovelyDialogCallback mNegativeCallback;
    private static Dialog mDialog;

    private LovelyDialog(Builder builder) {
        this.mTitle = builder.mTitle;
        this.mContent = builder.mContent;
        this.mContext = builder.mContext;
        this.mIcon = builder.mIcon;
        this.mAnimation = builder.mAnimation;
        this.mVisible = builder.mVisible;
        this.mPositiveCallback = builder.mPositiveCallback;
        this.mNegativeCallback = builder.mNegativeCallback;
        this.mPositiveText = builder.mPositiveText;
        this.mNegativeText = builder.mNegativeText;
        this.mPositiveColor = builder.mPositiveColor;
        this.mNegativeColor = builder.mNegativeColor;
        this.mBarColor = builder.mBarColor;
        this.mCancelable = builder.mCancelable;
    }

    public static class Builder {

        private String mTitle;
        private String mContent;
        private String mPositiveText;
        private String mNegativeText;
        private Context mContext;
        @DrawableRes
        private int mIcon;
        @ColorInt
        private int mPositiveColor;
        @ColorInt
        private int mNegativeColor;
        @ColorInt
        private int mBarColor;
        private Animation mAnimation;
        private Icon mVisible;
        private boolean mCancelable;

        private LovelyDialogCallback mPositiveCallback;
        private LovelyDialogCallback mNegativeCallback;

        public Builder(Context mContext) {
            this.mContext = mContext;
            this.mCancelable = true;
        }

        public Builder setTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        public Builder setContent(String mContent) {
            this.mContent = mContent;
            return this;
        }

        public Builder setPositiveText(String mPositiveText) {
            this.mPositiveText = mPositiveText;
            return this;
        }

        public Builder setNegativeText(String mNegativeText) {
            this.mNegativeText = mNegativeText;
            return this;
        }

        public Builder setIcon(int mIcon, Icon mVisible) {
            this.mIcon = mIcon;
            this.mVisible = mVisible;
            return this;
        }

        public Builder setPositiveColor(int mPositiveColor) {
            this.mPositiveColor = ContextCompat.getColor(mContext, mPositiveColor);
            return this;
        }

        public Builder setNegativeColor(int mNegativeColor) {
            this.mNegativeColor = ContextCompat.getColor(mContext, mNegativeColor);
            return this;
        }

        public Builder setBarColor(int mBarColor) {
            this.mBarColor = ContextCompat.getColor(mContext, mBarColor);
            return this;
        }

        public Builder setAnimation(Animation mAnimation) {
            this.mAnimation = mAnimation;
            return this;
        }

        public Builder isCancelable(boolean cancelable) {
            this.mCancelable = cancelable;
            return this;
        }

        public Builder onPositive(LovelyDialogCallback mPositiveCallback) {
            this.mPositiveCallback = mPositiveCallback;
            return this;
        }

        public Builder onNegative(LovelyDialogCallback mNegativeCallback) {
            this.mNegativeCallback = mNegativeCallback;
            return this;
        }

        public LovelyDialog build() {

            TextView mTvTitle;
            TextView mTvContent;
            ImageView mIvIcon;
            Button mPositiveBtn;
            Button mNegativeBtn;
            View mBarBackground;

            if (mAnimation == Animation.POP) {
                mDialog = new Dialog(mContext, R.style.PopTheme);
            } else if (mAnimation == Animation.SIDE) {
                mDialog = new Dialog(mContext, R.style.SideTheme);
            } else if (mAnimation == Animation.SLIDE) {
                mDialog = new Dialog(mContext, R.style.SlideTheme);
            } else {
                mDialog = new Dialog(mContext);
            }
            mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            if (mDialog.getWindow() != null) {
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            mDialog.setCancelable(mCancelable);
            mDialog.setContentView(R.layout.layout_dialog);
            mBarBackground = mDialog.findViewById(R.id.bar_background);
            mTvTitle = mDialog.findViewById(R.id.tv_title);
            mTvContent = mDialog.findViewById(R.id.tv_content);
            mIvIcon = mDialog.findViewById(R.id.iv_icon);
            mNegativeBtn = mDialog.findViewById(R.id.btn_negative);
            mPositiveBtn = mDialog.findViewById(R.id.btn_positive);
            if (TextUtils.isEmpty(mTitle)) {
                mTvTitle.setVisibility(View.GONE);
            } else {
                mTvTitle.setVisibility(View.VISIBLE);
                mTvTitle.setText(mTitle);
            }
            if (TextUtils.isEmpty(mContent)) {
                mTvContent.setVisibility(View.GONE);
            } else {
                mTvContent.setVisibility(View.VISIBLE);
                mTvContent.setText(mContent);
            }
            if (mPositiveColor != 0) {
                GradientDrawable bgShape = (GradientDrawable) mPositiveBtn.getBackground();
                bgShape.setColor(mPositiveColor);
            }
            if (mNegativeColor != 0) {
                GradientDrawable bgShape = (GradientDrawable) mNegativeBtn.getBackground();
                bgShape.setColor(mNegativeColor);
            }
            if (!TextUtils.isEmpty(mPositiveText)) {
                mPositiveBtn.setText(mPositiveText);
            }
            if (!TextUtils.isEmpty(mNegativeText)) {
                mNegativeBtn.setText(mNegativeText);
            }
            if (mBarColor != 0) {
                GradientDrawable bgShape = (GradientDrawable) mBarBackground.getBackground();
                bgShape.setColor(mBarColor);
            }
            if (mIcon != 0) {
                mIvIcon.setImageResource(mIcon);
            }
            if (mVisible == Icon.VISIBLE) {
                mIvIcon.setVisibility(View.VISIBLE);
            } else {
                mIvIcon.setVisibility(View.GONE);
            }
            if (mPositiveCallback != null) {
                mPositiveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPositiveCallback.onClick(mDialog);
                        mDialog.dismiss();
                    }
                });
            } else {
                mPositiveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                    }
                });
            }
            if (mNegativeCallback != null) {
                mNegativeBtn.setVisibility(View.VISIBLE);
                mNegativeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mNegativeCallback.onClick(mDialog);
                        mDialog.dismiss();
                    }
                });
            }
            return new LovelyDialog(this);
        }
    }

    public void show() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getPositiveText() {
        return mPositiveText;
    }

    public String getNegativeText() {
        return mNegativeText;
    }

    public Context getContext() {
        return mContext;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getPositiveColor() {
        return mPositiveColor;
    }

    public int getNegativeColor() {
        return mNegativeColor;
    }

    public int getBarColor() {
        return mBarColor;
    }

    public Animation getAnimation() {
        return mAnimation;
    }

    public Icon getVisible() {
        return mVisible;
    }

    public boolean isCancelable() {
        return mCancelable;
    }

    public LovelyDialogCallback getPositiveCallback() {
        return mPositiveCallback;
    }

    public LovelyDialogCallback getNegativeCallback() {
        return mNegativeCallback;
    }

    public static Dialog getDialog() {
        return mDialog;
    }
}
