# openlibs.i18n

The lib of java internationalization, includes resource bundle and db implementation.

@see http://daileyet.github.io/openlibs.i18n.

###Quick useage for the implementation java.util.ResourceBundle:
#####1. Directly use pack name</h5>
<blockquote>
<pre><code class="java">//resource pack dir and pack name; 
//put your resource bundle file Log.properties 
//under your project path "openthinks/libs/i18n/resource/i18n/"
String BASE_PACK_DIR = "openthinks/libs/i18n/resource/i18n/";
String LOG_PACK_NAME = "Log";
//get internationalization message by the properties key in bundle properties file
//get default locale message
String message = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME, "1000");
//get special locale message
message = I18n.getMessage(BASE_PACK_DIR + LOG_PACK_NAME,Locale.UK, "1000");
</code></pre>
</blockquote>
#####2. Use customized IBundleMessageType</h5>
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
### Locale change in application
###### Use class I18nApplicationLocale
<blockquote>
<pre><code>//example for Swing UI, make it as Observer and regiester to I18nApplicationLocale
class UI extends JFrame implements Observer{
 		private JButton button;
 		private JLabel label;
 		
 		public UI(){
 			//initialize component
 			//register to I18nApplicationLocale
 			I18nApplicationLocale.getInstance().addObserver(this);
 		}
 		
 		// Overrides Observer
		public void update(Observable o, Object argument) {
			setLocaleMessage();
 		}
 		
 		public void setLocaleMessage(){
 			button.setText(I18n.getMessage(CustomizedMessageType.UI,"2000"));
 			label.setText(I18n.getMessage(CustomizedMessageType.UI,"2001"));
 		}
}
// when the application locale changed, call the following statement
I18nApplicationLocale.getInstance().changeCurrentLocale(Locale.UK);
</code></pre>
</blockquote>
