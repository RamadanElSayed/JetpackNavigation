package com.journaldev.androidjetpacknavigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_second_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + getArguments().getBoolean("test_boolean"), Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + FirstFragmentArgs.fromBundle(getArguments()).getTestString(), Toast.LENGTH_SHORT).show();

        Button button = view.findViewById(R.id.button_frag2);
        Button button1 = view.findViewById(R.id.button_frag2_1);


        final Bundle bundle = new Bundle();
        bundle.putBoolean("test_boolean", true);

        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_secondFragment_to_thirdFragment, bundle);

//                final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
//                navController.navigateUp();
//
//                navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
//                    @Override
//                    public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
//                        Log.d("TAG", destination.getLabel() + " ");
//                    }
//                });
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                navController.navigateUp();

                navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
                    @Override
                    public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                        Log.d("TAG", destination.getLabel() + " ");

                    }
                });

            }
        });
    }

}
