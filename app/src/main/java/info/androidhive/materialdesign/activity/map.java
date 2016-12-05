package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import info.androidhive.materialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link map.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link map#newInstance} factory method to
 * create an instance of this fragment.
 */
public class map extends Fragment {int i = 0;

    Integer [] images = {
            R.drawable.sp2,
            R.drawable.sp
    };
    Button b_next;
    Button b_prev;
    ImageSwitcher switcher;
    ImageView view;
    TextView textView;
    public map() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        ///




        view = (ImageView) rootView.findViewById(R.id.imageView);
        switcher = (ImageSwitcher) rootView.findViewById(R.id.imageid);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT ,ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.in);
        Animation out = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.out);

        switcher.setAnimation(in);
        switcher.setAnimation(out);
        textView = (TextView) rootView.findViewById(R.id.textView);

        b_next = (Button) rootView.findViewById(R.id.b_next);
        b_prev = (Button) rootView.findViewById(R.id.b_prev);


        b_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0){
                    images[0] = R.drawable.sp;
                    images[1] = R.drawable.sp2;

                }
                if (i==1){
                    textView.setText("first floor");
                }



                if (i>0){
                    i--;
                    switcher.setImageResource(images[i]);
                    view.setVisibility(View.INVISIBLE);

                }

            }
        });
        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==0){
                    images[0] = R.drawable.sp;
                    images[1] = R.drawable.sp2;

                }
                if (i ==0){
                    textView.setText("second floor");
                }


                if (i < 1){
                    i++;
                    view.setVisibility(View.INVISIBLE);
                    switcher.setImageResource(images[i]);


                }
                else if(i > 0){

                    Toast.makeText(getActivity().getApplicationContext() , "last image", Toast.LENGTH_SHORT).show();

                }
            }
        });





        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
