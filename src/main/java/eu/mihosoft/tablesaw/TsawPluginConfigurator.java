package eu.mihosoft.tablesaw;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;



/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class TsawPluginConfigurator extends VPluginConfigurator{

    public TsawPluginConfigurator() {
        //specify the plugin name and version
        setIdentifier(new PluginIdentifier("Tablesaw", "0.1"));

        // optionally allow other plugins to use the api of this plugin
        // you can specify packages that shall be
        // exported by using the exportPackage() method:
        //
        // exportPackage("com.your.package");

        exportPackage("tech.tablesaw", true);
        exportPackage("eu.mihosoft.tablesaw", true);

        // describe the plugin
        setDescription("Plugin Description");

        // copyright info
        setCopyrightInfo("Sample-Plugin",
                "(c) Your Name",
                "www.you.com", "License Name", "License Text...");

        // specify dependencies
        // addDependency(new PluginDependency("VRL", "0.4.0", "0.4.0"));
    }

    @Override
    public void register(PluginAPI api) {

        // register plugin with canvas
        if (api instanceof VPluginAPI) {
            VPluginAPI vapi = (VPluginAPI) api;

            // Register visual components:
            //
            // Here you can add additional components,
            // type representations, styles etc.
            //
            // ** NOTE **
            //
            // To ensure compatibility with future versions of VRL,
            // you should only use the vapi or api object for registration.
            // If you directly use the canvas or its properties, please make sure
            // that you specify the VRL versions your plugin is compatible with
            // in the constructor of this plugin configurator because the
            // internal api is likely to change.
            //
            // examples:
            //
            // vapi.addComponent(MyComponent.class);
            // vapi.addTypeRepresentation(MyType.class);

            vapi.addComponent(TutorialComponent.class);

            vapi.addTypeRepresentation(TableType.class);
        }
    }

    @Override
    public void unregister(PluginAPI api) {
        // nothing to unregister
    }

    @Override
    public void init(InitPluginAPI iApi) {
        // nothing to init
    }
}
