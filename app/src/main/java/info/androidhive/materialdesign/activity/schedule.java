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
import android.widget.Toast;
import android.widget.ViewSwitcher;

import info.androidhive.materialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link schedule.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link schedule#newInstance} factory method to
 * create an instance of this fragment.
 */
public class schedule extends Fragment {int i = 0;

    Integer [] images = {
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s1
    };
    Button b_next;
    Button b_prev;
    ImageSwitcher switcher;
    ImageView view;
    public schedule() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
        ///




        view = (ImageView) rootView.findViewById(R.id.imageView);
        switcher = (ImageSwitcher) rootView.findViewById(R.id.switcher);
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

        b_next = (Button) rootView.findViewById(R.id.b_next);
        b_prev = (Button) rootView.findViewById(R.id.b_prev);


        b_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1){
                    images[0] = R.drawable.s1;
                    images[1] = R.drawable.s2;
                    images[2] = R.drawable.s3;
                    images[3] = R.drawable.s4;

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
                if (i==1){
                    images[0] = R.drawable.s1;
                    images[1] = R.drawable.s2;
                    images[2] = R.drawable.s3;
                    images[3] = R.drawable.s4;

                }

                if (i < images.length){

                    view.setVisibility(View.INVISIBLE);
                    switcher.setImageResource(images[i]);
                    i++;

                }
                else if(i == images.length){

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
