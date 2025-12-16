package com.example.bookcare_authentication;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.example.bookcare_authentication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(binding.navView, navController);
            NavigationUI.setupActionBarWithNavController(this, navController);

            navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
                ActionBar actionBar = getSupportActionBar();
                if (actionBar == null) {
                    return;
                }

                int destinationId = destination.getId();

                if (destinationId == R.id.welcomeFragment ||
                        destinationId == R.id.loginFragment ||
                        destinationId == R.id.registerFragment ||
                        destinationId == R.id.forgotPasswordFragment) {
                    actionBar.hide();
                    binding.navView.setVisibility(View.GONE);
                } else {
                    actionBar.show();
                    binding.navView.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}
