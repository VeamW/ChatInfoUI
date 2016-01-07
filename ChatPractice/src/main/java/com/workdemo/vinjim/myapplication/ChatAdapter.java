package com.workdemo.vinjim.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by VinJim on 2016/1/2.
 */
public class ChatAdapter extends BaseAdapter {
    public static final int VALUE_TIME_TIP = 0;// 7种不同的布局
    public static final int VALUE_LEFT_TEXT = 1;
    public static final int VALUE_LEFT_IMAGE = 2;
    public static final int VALUE_LEFT_AUDIO = 3;
    public static final int VALUE_RIGHT_TEXT = 4;
    public static final int VALUE_RIGHT_IMAGE = 5;
    public static final int VALUE_RIGHT_AUDIO = 6;

    private LayoutInflater mInflater;

    private List<Message> myList;


    public ChatAdapter(Context context, List<Message> myList) {
        this.myList = myList;

        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Message getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message msg = myList.get(position); //先获取Message对象
        int type = getItemViewType(position);
        ViewHolderTime time;
        ViewHolderLeftAudio leftAudio;
        ViewHolderLeftImg leftImg;
        ViewHolderLeftText leftText;
        ViewHolderRightAudio rightAudio;
        ViewHolderRightImg rightImg;
        ViewHolderRightText rightText;

        if (convertView == null) {
            switch (type) {
                //时间
                case VALUE_TIME_TIP:
                    time = new ViewHolderTime();
                    convertView = mInflater.inflate(R.layout.list_item_time_tip, null);
                    time.tvTimeTip = (TextView) convertView
                            .findViewById(R.id.tv_time_tip);
                    time.tvTimeTip.setText(msg.getValue());
                    convertView.setTag(time);
                    break;
                //左边
                case VALUE_LEFT_TEXT:
                    leftText = new ViewHolderLeftText();
                    convertView = mInflater.inflate(R.layout.list_item_left_text, null);
                    leftText.ivLeftIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                    leftText.btnLeftText = (Button) convertView.findViewById(R.id.btn_left_text);
                    leftText.btnLeftText.setText(msg.getValue());
                    convertView.setTag(leftText);
                    break;
                case VALUE_LEFT_IMAGE:
                    leftImg = new ViewHolderLeftImg();
                    convertView = mInflater.inflate(R.layout.list_item_left_iamge, null);
                    leftImg.ivLeftIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                    leftImg.ivLeftImage = (ImageView) convertView.findViewById(R.id.iv_left_image);
                    leftImg.ivLeftImage.setImageResource(R.drawable.test);
                    convertView.setTag(leftImg);
                    break;
                case VALUE_LEFT_AUDIO:
                    leftAudio = new ViewHolderLeftAudio();
                    convertView = mInflater.inflate(R.layout.list_item_left_audio, null);
                    leftAudio.ivLeftIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                    leftAudio.btnLeftAudio = (Button) convertView.findViewById(R.id.btn_left_audio);
                    leftAudio.tvLeftAudioTime = (TextView) convertView.findViewById(R.id.tv_left_audio_time);
                    leftAudio.tvLeftAudioTime.setText(msg.getValue());
                    convertView.setTag(leftAudio);
                    break;
                //右边
                case VALUE_RIGHT_TEXT:
                    rightText = new ViewHolderRightText();
                    convertView = mInflater.inflate(R.layout.list_item_right_text, null);
                    rightText.ivRightIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                    rightText.btnRightText = (Button) convertView.findViewById(R.id.btn_right_text);
                    rightText.btnRightText.setText(msg.getValue());
                    convertView.setTag(rightText);
                    break;
                case VALUE_RIGHT_IMAGE:
                    rightImg = new ViewHolderRightImg();
                    convertView = mInflater.inflate(R.layout.list_item_right_iamge, null);
                    rightImg.ivRightIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                    rightImg.ivRightImage = (ImageView) convertView.findViewById(R.id.iv_right_image);
                    rightImg.ivRightImage.setImageResource(R.drawable.test);
                    convertView.setTag(rightImg);
                    break;
                case VALUE_RIGHT_AUDIO:
                    rightAudio = new ViewHolderRightAudio();
                    convertView = mInflater.inflate(R.layout.list_item_right_audio, null);
                    rightAudio.ivRightIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
                    rightAudio.btnRightAudio = (Button) convertView.findViewById(R.id.btn_right_audio);
                    rightAudio.tvRightAudioTime = (TextView) convertView.findViewById(R.id.tv_right_audio_time);
                    rightAudio.tvRightAudioTime.setText(msg.getValue());
                    convertView.setTag(rightAudio);
                    break;
            }
        } else {
            switch (type) {
                case VALUE_TIME_TIP:
                    time=(ViewHolderTime)convertView.getTag();
                    time.tvTimeTip.setText(msg.getValue());
                    break;
                case VALUE_LEFT_TEXT:
                    leftText=(ViewHolderLeftText)convertView.getTag();
                    leftText.btnLeftText.setText(msg.getValue());
                    break;
                case VALUE_LEFT_IMAGE:
                    leftImg=(ViewHolderLeftImg)convertView.getTag();
                    leftImg.ivLeftImage.setImageResource(R.drawable.test);
                    break;
                case VALUE_LEFT_AUDIO:
                    leftAudio=(ViewHolderLeftAudio)convertView.getTag();
                    leftAudio.tvLeftAudioTime.setText(msg.getValue());
                    break;
                case VALUE_RIGHT_TEXT:
                    rightText=(ViewHolderRightText)convertView.getTag();
                    rightText.btnRightText.setText(msg.getValue());
                    break;
                case VALUE_RIGHT_IMAGE:
                    rightImg=(ViewHolderRightImg)convertView.getTag();
                    rightImg.ivRightImage.setImageResource(R.drawable.test);
                    break;
                case VALUE_RIGHT_AUDIO:
                    rightAudio=(ViewHolderRightAudio)convertView.getTag();
                    rightAudio.tvRightAudioTime.setText(msg.getValue());
                    break;
                default:
                    break;
            }
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = myList.get(position);
        int type = msg.getType();
        Log.e("TYPE:", "" + type);
        return type;
    }


    /**
     * 返回所有的layout的数量
     */
    @Override
    public int getViewTypeCount() {
        return 7;
    }

    class ViewHolderTime {
        private TextView tvTimeTip;// 时间
    }

    class ViewHolderRightText {
        private ImageView ivRightIcon;// 右边的头像
        private Button btnRightText;// 右边的文本
    }

    class ViewHolderRightImg {
        private ImageView ivRightIcon;// 右边的头像
        private ImageView ivRightImage;// 右边的图像
    }

    class ViewHolderRightAudio {
        private ImageView ivRightIcon;// 右边的头像
        private Button btnRightAudio;// 右边的声音
        private TextView tvRightAudioTime;// 右边的声音时间
    }

    class ViewHolderLeftText {
        private ImageView ivLeftIcon;// 左边的头像
        private Button btnLeftText;// 左边的文本
    }

    class ViewHolderLeftImg {
        private ImageView ivLeftIcon;// 左边的头像
        private ImageView ivLeftImage;// 左边的图像
    }

    class ViewHolderLeftAudio {
        private ImageView ivLeftIcon;// 左边的头像
        private Button btnLeftAudio;// 左边的声音
        private TextView tvLeftAudioTime;// 左边的声音时间
    }
}
