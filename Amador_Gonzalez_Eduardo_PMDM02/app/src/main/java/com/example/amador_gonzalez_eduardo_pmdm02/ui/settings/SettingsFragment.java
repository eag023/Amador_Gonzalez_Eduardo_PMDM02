package com.example.amador_gonzalez_eduardo_pmdm02.ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.amador_gonzalez_eduardo_pmdm02.R;
import com.example.amador_gonzalez_eduardo_pmdm02.databinding.FragmentSettingsBinding;

import java.util.Locale;

public class SettingsFragment extends Fragment {

    Switch swtIdioma;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        preferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();

        swtIdioma = root.findViewById(R.id.switch1);
        if (preferences.getBoolean("idioma", false)) {
            swtIdioma.setChecked(true);
        } else {
            swtIdioma.setChecked(false);
        }

        swtIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("idioma", swtIdioma.isChecked());
                editor.apply();

                if (preferences.getBoolean("idioma", false)) {
                    LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("en-EN");
                    AppCompatDelegate.setApplicationLocales(appLocale);
                } else {
                    LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("es-ES");
                    AppCompatDelegate.setApplicationLocales(appLocale);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}