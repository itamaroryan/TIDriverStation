package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import communication.tcp.TCPCommunicator;
import gui.DriverStation;

/**
 * Sends an enable event to the robot
 * @author John
 *
 */
public class RobotEnableAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JSONObject enableEvent = new JSONObject();
		enableEvent.put("event-id", "enable");
		TCPCommunicator.sendMessage(enableEvent);
		
		if(TCPCommunicator.getNextResponse()) {
			DriverStation.getInstance().allowRobotEnable(false);
			DriverStation.getInstance().allowRobotDisable(true);
		}
	}
	
}
