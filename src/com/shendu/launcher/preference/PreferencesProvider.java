/*
 * Copyright (C) 2011 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shendu.launcher.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.shendu.launcher.AppsCustomizePagedView;
import com.shendu.launcher.LauncherApplication;
import com.shendu.launcher.Workspace;

public final class PreferencesProvider {
    public static final String PREFERENCES_KEY = "com.shendu.launcher_preferences";

    public static final String PREFERENCES_CHANGED = "preferences_changed";
    public static final String PREFERENCES_EFFECT = "ui_homescreen_scrolling_transition_effect";
    public static final String PREFERENES_SEARCH = "ui_homescreen_general_search";
    public static final String SEARCHBAR_EXIST = "preferences_searchbar_exist";

    public static class Interface {
        public static class Homescreen {
            public static int getNumberHomescreens(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getInt("ui_homescreen_screens", 1);
            }
            public static int getDefaultHomescreen(Context context, int def) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getInt("ui_homescreen_default_screen", def + 1) - 1;
            }
            public static int getCellCountX(Context context, int def) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                String[] values = preferences.getString("ui_homescreen_grid", "0|" + def).split("\\|");
                try {
                    return Integer.parseInt(values[1]);
                } catch (NumberFormatException e) {
                    return def;
                }
            }
            public static int getCellCountY(Context context, int def) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                String[] values = preferences.getString("ui_homescreen_grid", def + "|0").split("\\|");;
                try {
                    return Integer.parseInt(values[0]);
                } catch (NumberFormatException e) {
                    return def;
                }
            }
            public static int getScreenPaddingVertical(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return (int)((float) preferences.getInt("ui_homescreen_screen_padding_vertical", 0) * 3.0f *
                        LauncherApplication.getScreenDensity());
            }
            public static int getScreenPaddingHorizontal(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return (int)((float) preferences.getInt("ui_homescreen_screen_padding_horizontal", 0) * 3.0f *
                        LauncherApplication.getScreenDensity());
            }
            public static boolean getShowSearchBar(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getBoolean(PREFERENES_SEARCH, true);
            }
            public static boolean getResizeAnyWidget(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getBoolean("ui_homescreen_general_resize_any_widget", false);
            }
            public static boolean getHideIconLabels(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getBoolean("ui_homescreen_general_hide_icon_labels", false);
            }
            public static class Scrolling {
                public static boolean getScrollWallpaper(Context context) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_homescreen_scrolling_scroll_wallpaper", false);
                }
                public static Workspace.TransitionEffect getTransitionEffect(Context context, String def) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return Workspace.TransitionEffect.valueOf(
                            preferences.getString(PREFERENCES_EFFECT, def));
                }
                public static boolean getFadeInAdjacentScreens(Context context, boolean def) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_homescreen_scrolling_fade_adjacent_screens", def);
                }
            }
            public static class Indicator {
                public static boolean getShowScrollingIndicator(Context context) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_homescreen_indicator_enable", true);
                }
                public static boolean getFadeScrollingIndicator(Context context) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_homescreen_indicator_fade", true);
                }
                public static boolean getShowDockDivider(Context context) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_homescreen_indicator_background", true);
                }
            }
            
    
        }

        public static class Drawer {
            public static boolean getJoinWidgetsApps(Context context) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getBoolean("ui_drawer_widgets_join_apps", false);
            }
            public static class Scrolling {
               /*public static AppsCustomizePagedView.TransitionEffect getTransitionEffect(Context context, String def) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return AppsCustomizePagedView.TransitionEffect.valueOf(
                            preferences.getString("ui_drawer_scrolling_transition_effect", def));
                }*/
                public static boolean getFadeInAdjacentScreens(Context context) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_drawer_scrolling_fade_adjacent_screens", false);
                }
            }
            public static class Indicator {
                public static boolean getShowScrollingIndicator(Context context) {
                   final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_drawer_indicator_enable", true);
                }
                public static boolean getFadeScrollingIndicator(Context context) {
                    final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                    return preferences.getBoolean("ui_drawer_indicator_fade", true);
                }
            }
        }

        public static class Dock {

        }

        public static class Icons {

        }

        public static class General {
            public static boolean getAutoRotate(Context context, boolean def) {
                final SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_KEY, 0);
                return preferences.getBoolean("ui_general_orientation", def);
            }
        }
    }

    public static class Application {

    }
}
