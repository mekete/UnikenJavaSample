# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.uniken.rdna.** { *; }
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-keep class android.app.job.IJobCallback$Stub$Proxy { *; }
########### MTD ##########
# for squareup picasso
-dontwarn com.squareup.okhttp.**
# for okhttp
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
#####################
# Retrofit 2.X
# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod
# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
@retrofit2.http.* <methods>;
}
# Ignore annotation used for build tooling.
# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**
# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit
# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*
# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>
###############################
#SqlCipher
-keep class net.sqlcipher.** { *; }
-keep class net.sqlcipher.database.* { *; }
#for jsoup
-keep public class org.jsoup.** {
public *;
}
# don't touch MTD class
-keep class com.better.active.shield.engine.BetterMTD { *; }
-keep class com.better.active.shield.engine.threat.Alert { *; }
-keep class com.better.active.shield.engine.threat.AppThreat { *; }
-keep class com.better.active.shield.engine.threat.DeviceThreat { *; }
-keep class com.better.active.shield.engine.threat.NetworkThreat { *; }
-keep class com.better.active.shield.engine.model.App { *; }
-dontwarn com.better.active.shield.engine.model.DeviceApps
-dontwarn com.better.active.shield.engine.utils.APKUtils
# for papertrail logging
-keep class org.productivity.java.syslog4j.** { *; }
-dontwarn org.productivity.java.syslog4j.impl.log4j.Syslog4jAppenderSkeleton
-dontwarn org.productivity.java.syslog4j.impl.unix.socket.UnixSocketSyslog
-dontwarn org.apache.commons.pool.**
-dontwarn com.sun.jna.**
-dontwarn org.apache.log4j.**
-dontwarn org.apache.log.**
# org.json
-dontwarn org.json.*
# for apache base64 ilb
-dontwarn org.apache.commons.codec.binary.Base64
# realm io
-keep @interface io.realm.annotations.RealmModule { *; }
-keep class io.realm.annotations.RealmModule { *; }
-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class *
-dontwarn javax.**
-dontwarn io.realm.**
## Rules for Gson
# For using GSON @Expose annotation
-keepattributes *Annotation*
# Gson specific classes

-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
# Application classes that will be serialized/deserialized over Gson
-keep class com.better.active.shield.engine.api.** { <fields>; }