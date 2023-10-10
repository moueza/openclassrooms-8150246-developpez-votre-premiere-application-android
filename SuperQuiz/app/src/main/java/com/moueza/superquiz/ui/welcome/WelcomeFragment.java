package com.moueza.superquiz.ui.welcome;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import com.moueza.superquiz.R;
import com.moueza.superquiz.databinding.FragmentWelcomeBinding;
import com.moueza.superquiz.ui.quiz.QuizFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static String TAG = "Peter";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentWelcomeBinding binding;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragment newInstance(String param1, String param2) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     * { #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     *
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, add a {@link LifecycleObserver} on the
     * activity's Lifecycle, removing it when it receives the
     * {@link Lifecycle.State#CREATED} callback.
     *
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "WelcomeFragment.onCreate() called");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_welcome, container, false);
        /*TODO pas d appel à super ?*/
        Log.d(TAG, "WelcomeFragment.onCreateView() called");

        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "WelcomeFragment.onViewCreated() called");

        binding.playButton.setEnabled(false);//++++ ++++++++++
        binding.usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.playButton.setEnabled(!s.toString().isEmpty());


                binding.playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // The user just clicked
                        //naviguer vers le fragment de quiz
                        Log.d(TAG, "Clic !");
                        FragmentManager fragmentManager = getParentFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        QuizFragment quizFragment = new QuizFragment(); //QuizFragment.newInstance();
                        fragmentTransaction.add(R.id.fragment_container_view_tag, quizFragment);
                        //fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                });
            }
        });
    }


    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link #onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "WelcomeFragment.onStart() called");

    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to {@link #onResume() Activity.onResume} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "WelcomeFragment.onResume() called");

    }

    /**
     * Called when the Fragment is no longer resumed.  This is generally
     * tied to {@link #onPause() Activity.onPause} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "WelcomeFragment.onPause() called");

    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to {@link #onStop() Activity.onStop} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "WelcomeFragment.onStop() called");

    }

    /**
     * Called when the view previously created by {@link #onCreateView} has
     * been detached from the fragment.  The next time the fragment needs
     * to be displayed, a new view will be created.  This is called
     * after {@link #onStop()} and before {@link #onDestroy()}.  It is called
     * <em>regardless</em> of whether {@link #onCreateView} returned a
     * non-null view.  Internally it is called after the view's state has
     * been saved but before it has been removed from its parent.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "WelcomeFragment.onDestroyView() called");

    }

    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "WelcomeFragment.onDestroy() called");

    }

    /**
     * Called when the fragment is no longer attached to its activity.  This
     * is called after {@link #onDestroy()}.
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "WelcomeFragment.onDetach() called");

    }

}