package nl.tue.vagariapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return Upload.myPhotos.size();
    }

    public Object getItem(int position) {
        return Upload.myPhotos.get(position);
    }

    public long getItemId(int position) {return 0;}

    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {  // if it's not recycled, initialize some attributes
            gridView = new View(mContext);

            gridView = inflater.inflate(R.layout.grid_item, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.picture);
            //imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);

            imageView.setImageBitmap(Upload.myPhotos.get(position));

        } else {
            gridView = (View) convertView;

        }
        return gridView;

    }
}