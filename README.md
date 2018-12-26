### lovelydialog
A lovely Dialog

![0]

### usage
```java
new LovelyDialog.Builder(this).setTitle("LoveLy Dialog").setContent("一个好看的Dialog")
    .setAnimation(Animation.SLIDE).setIcon(R.mipmap.ic_launcher_round, Icon.VISIBLE)
    .setBarColor(R.color.colorPrimaryDark).onPositive(new LovelyDialogCallback() {
        @Override
        public void onClick(@NonNull Dialog dialog) {
            showToast("你点击了Positive按钮");
        }
    }).onNegative(new LovelyDialogCallback() {
        @Override
        public void onClick(@NonNull Dialog dialog) {
            showToast("你点击了Negative按钮");
        }
    }).show();
```
[0]:https://github.com/Rairmmd/lovelydialog/blob/master/device-2018-12-27-011451.png