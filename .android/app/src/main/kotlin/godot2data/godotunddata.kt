package godot2data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ezgodotaddon.host.R
import org.godotengine.godot.Godot
import org.godotengine.godot.GodotFragment
import org.godotengine.godot.GodotHost
import org.godotengine.godot.plugin.GodotPlugin


/**
 * Implements the [GodotHost] interface so it can access functionality from the [Godot] instance.
 */
class godotunddata: AppCompatActivity(), GodotHost {

    private var godotFragment: GodotFragment? = null

    //internal var appPlugin: AppPlugin? = null


    /*


    private fun initAppPluginIfNeeded(godot: Godot) {
        if (appPlugin == null) {
            appPlugin = AppPlugin(godot)
        }
    } */

    override fun getActivity() = this

    override fun getGodot() = godotFragment?.godot


    /*
    override fun getHostPlugins(godot: Godot): Set<GodotPlugin> {
        initAppPluginIfNeeded(godot)

        return setOf(appPlugin!!)
    }
    */
}





