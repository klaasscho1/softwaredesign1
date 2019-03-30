// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package RootElement.ClassDiagram.Package1;

import java.awt.Container;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDesktopPane;
import javax.vecmath.Vector3d;
import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;

/************************************************************/
/**
 * 
 */
public class Main {
	static CentralStation central;
	static EnvironmentDescription environment;
	static int emergencyKeyCode = 70;

	public static void main(String[] args) {
		central = new CentralStation();
		
		System.setProperty("j3d.implicitAntialiasing", "true");
		
		environment = new Environment();
	
		central.createCamera(environment, new Vector3d(2,0,3), "camera");
		central.createBumper(environment, new Vector3d(0,0,6), "bumper");
		central.createPicker(environment, new Vector3d(1,0,5), "picker");
		central.initializeMission(20, environment);
		
		Simbad frame = new Simbad(environment, false);
      	frame.update(frame.getGraphics());
      	
		// Listen for emergency key press
      	KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == emergencyKeyCode) {
                    central.abort();
                    e.consume();
                }
                return false;
            }
        });
	}
};
