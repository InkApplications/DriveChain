package drivechain.androidservices

import android.accounts.AccountManager
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.app.usage.StorageStatsManager
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.companion.CompanionDeviceManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.content.pm.ShortcutManager
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.midi.MidiManager
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.aware.WifiAwareManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.health.SystemHealthManager
import android.os.storage.StorageManager
import android.service.wallpaper.WallpaperService
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.hardware.display.DisplayManagerCompat
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textclassifier.TextClassificationManager
import android.view.textservice.TextServicesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Android's inconsistent and type-unsafe System-Service API, in one type-safe and consistent Module.
 *
 * Use this to inject android's system services directly into your app instead of injecting a whole
 * context directly.
 */
@Module class AndroidSystemServiceModule {
    @Provides @Singleton fun accessibility(context: Context) = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
    @Provides @Singleton fun account(context: Context) = context.getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
    @Provides @Singleton fun activity(context: Context) = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    @Provides @Singleton fun alarm(context: Context) = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    @RequiresApi(21) @Provides @Singleton fun appWidget(context: Context) = context.getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager?
    @RequiresApi(19) @Provides @Singleton fun appOps(context: Context) = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager?
    @Provides @Singleton fun audio(context: Context) = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    @RequiresApi(21) @Provides @Singleton fun battery(context: Context) = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager?
    @RequiresApi(18) @Provides @Singleton fun bluetooth(context: Context) = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager?
    @RequiresApi(21) @Provides @Singleton fun camera(context: Context) = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager?
    @RequiresApi(19) @Provides @Singleton fun captioning(context: Context) = context.getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager?
    @RequiresApi(23) @Provides @Singleton fun carrierConfig(context: Context) = context.getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager?
    @Provides @Singleton fun clipboard(context: Context) = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    @RequiresApi(26) @Provides @Singleton fun companionDevice(context: Context) = context.getSystemService(Context.COMPANION_DEVICE_SERVICE) as CompanionDeviceManager?
    @Provides @Singleton fun connectivity(context: Context) = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    @RequiresApi(19) @Provides @Singleton fun consumerIr(context: Context) = context.getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager?
    @Provides @Singleton fun devicePolicy(context: Context) = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
    @Provides @Singleton fun displayCompat(context: Context) = DisplayManagerCompat.getInstance(context)
    @Provides @Singleton fun download(context: Context) = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    @Provides @Singleton fun dropbox(context: Context) = context.getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager
    @Provides @Singleton fun fingerprintCompat(context: Context) = FingerprintManagerCompat.from(context)
    @RequiresApi(24) @Provides @Singleton fun hardwareProperties(context: Context) = context.getSystemService(Context.HARDWARE_PROPERTIES_SERVICE) as HardwarePropertiesManager?
    @Provides @Singleton fun inputMethod(context: Context) = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    @RequiresApi(16) @Provides @Singleton fun input(context: Context) = context.getSystemService(Context.INPUT_SERVICE) as InputManager?
    @RequiresApi(21) @Provides @Singleton fun jobScheduler(context: Context) = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler?
    @Provides @Singleton fun keyguard(context: Context) = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
    @RequiresApi(21) @Provides @Singleton fun launcherApps(context: Context) = context.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps?
    @Provides @Singleton fun layoutInflater(context: Context) = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    @Provides @Singleton fun location(context: Context) = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    @RequiresApi(21) @Provides @Singleton fun mediaProjection(context: Context) = context.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager?
    @RequiresApi(16) @Provides @Singleton fun mediaRouter(context: Context) = context.getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter?
    @RequiresApi(21) @Provides @Singleton fun mediaSession(context: Context) = context.getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager?
    @RequiresApi(23) @Provides @Singleton fun midi(context: Context) = context.getSystemService(Context.MIDI_SERVICE) as MidiManager?
    @RequiresApi(23) @Provides @Singleton fun networkStats(context: Context) = context.getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager?
    @Provides @Singleton fun nfc(context: Context) = context.getSystemService(Context.NFC_SERVICE) as NfcManager
    @Provides @Singleton fun notification(context: Context) = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    @Provides @Singleton fun notificationCompat(context: Context) = NotificationManagerCompat.from(context)
    @RequiresApi(16) @Provides @Singleton fun nsd(context: Context) = context.getSystemService(Context.NSD_SERVICE) as NsdManager?
    @Provides @Singleton fun power(context: Context) = context.getSystemService(Context.POWER_SERVICE) as PowerManager
    @RequiresApi(21) @Provides @Singleton fun restrictions(context: Context) = context.getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager?
    @Provides @Singleton fun search(context: Context) = context.getSystemService(Context.SEARCH_SERVICE) as SearchManager
    @Provides @Singleton fun sensor(context: Context) = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    @RequiresApi(25) @Provides @Singleton fun shortcut(context: Context) = context.getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager?
    @Provides @Singleton fun storage(context: Context) = context.getSystemService(Context.STORAGE_SERVICE) as StorageManager
    @RequiresApi(26) @Provides @Singleton fun storageStats(context: Context) = context.getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager?
    @RequiresApi(24) @Provides @Singleton fun systemHealth(context: Context) = context.getSystemService(Context.SYSTEM_HEALTH_SERVICE) as SystemHealthManager?
    @RequiresApi(21) @Provides @Singleton fun telecom(context: Context) = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager?
    @Provides @Singleton fun telephony(context: Context) = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    @RequiresApi(22) @Provides @Singleton fun subscriptionManager(context: Context) = context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager?
    @RequiresApi(26) @Provides @Singleton fun textClassification(context: Context) = context.getSystemService(Context.TEXT_CLASSIFICATION_SERVICE) as TextClassificationManager?
    @Provides @Singleton fun textServices(context: Context) = context.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager
    @RequiresApi(21) @Provides @Singleton fun tvInput(context: Context) = context.getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager?
    @Provides @Singleton fun uiMode(context: Context) = context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
    @RequiresApi(22) @Provides @Singleton fun usageStats(context: Context) = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager?
    @Provides @Singleton fun usb(context: Context) = context.getSystemService(Context.USB_SERVICE) as UsbManager
    @RequiresApi(17) @Provides @Singleton fun userManager(context: Context) = context.getSystemService(Context.USER_SERVICE) as UserManager?
    @Provides @Singleton fun vibrator(context: Context) = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    @Provides @Singleton fun wallpaper(context: Context) = context.getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager
    @RequiresApi(26) @Provides @Singleton fun wifiAware(context: Context) = context.getSystemService(Context.WIFI_AWARE_SERVICE) as WifiAwareManager?
    @Provides @Singleton fun wifiP2p(context: Context) = context.getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
    @Provides @Singleton fun wifi(context: Context) = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    @Provides @Singleton fun windowMan(context: Context) = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
}