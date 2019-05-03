### lovelydialog
A lovely Dialog

![0]

### usage
```
implementation 'com.rairmmd:lovelydialog:1.0.0'
```

```java
new LovelyDialog.Builder(this).setTitle("LoveLy Dialog").setContent("一个好看的Dialog")
    .setAnimation(Animation.POP).setIcon(R.mipmap.ic_launcher_round, Icon.VISIBLE)
    .setBarColor(R.color.colorPrimaryDark).setPositiveColor(R.color.colorAccent)
    .setNegativeColor(R.color.colorPrimary).onPositive(new LovelyDialogCallback() {
        @Override
        public void onClick(@NonNull Dialog dialog) {
            showToast("你点击了Positive按钮");
        }
    }).onNegative(new LovelyDialogCallback() {
        @Override
        public void onClick(@NonNull Dialog dialog) {
            showToast("你点击了Negative按钮");
        }
}).build().show();
```
[0]:https://github.com/Rairmmd/lovelydialog/blob/master/device-2019-05-03-161044.png
