# openlibs.i18n

The lib of java internationalization, includes resource bundle and db implementation.

@see http://daileyet.github.io/openlibs.i18n.

<h3>Quick useage for the implementation java.util.ResourceBundle:</h3>
<h5>1. Directly use pack name</h5>
<blockquote>
<pre><code class="java">//resource pack dir and pack name; 
//put your resource bundle file Log.properties 
//under your project path "openthinks/libs/i18n/resource/i18n/"
String BASE_PACK_DIR = "openthinks/libs/i18n/resource/i18n/";
String LOG_PACK_NAME = "Log";
//get internationalization message by the proptiters key in bundle properties file
//get default locale message
String message = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, "1000");
//get special locale message
message = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME,Locale.UK, "1000");
</code></pre>
</blockquote>
<h5>2. Use customized IBundleMessageType</h5>
<blockquote>
<pre><code class="java">//define a customized message type, here is a enum;
//it also can be normal class just implement interface IBundleMessageType
public enum CustomizedMessageType implements IBundleMessageType{
	LOG, EXCEPTION, UI;
	@Override
	public String value() {
		return name() + ":" + BASE_PACK_DIR + name();
	}
	@Override
	public String getPackName() {
		//openthinks/libs/i18n/resource/i18n/LOG
		//openthinks/libs/i18n/resource/i18n/EXCEPTION
		//openthinks/libs/i18n/resource/i18n/UI
		return BASE_PACK_DIR + name();
	}
	@Override
	public String getMessageType() {
		return name();
	}
	
	public static final String BASE_PACK_DIR = "openthinks/libs/i18n/resource/i18n/"; 
}
//get default locale message
String message = I18n.getMessage(CustomizedMessageType.LOG, "1000");
//get special locale message
message = I18n.getMessage(CustomizedMessageType.LOG,Locale.UK, "1000");
</code>
</pre>
</blockquote>

