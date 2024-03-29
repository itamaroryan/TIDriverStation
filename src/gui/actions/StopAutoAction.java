package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import communication.tcp.TCPCommunicator;
import gui.DriverStation;

/**
 * Sends a stop auto event to the robot
 * @author John
 *
 */
public class StopAutoAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		JSONObject stopAutoEvent = new JSONObject();
		stopAutoEvent.put("event-id", "stop-auto");
		TCPCommunicator.sendMessage(stopAutoEvent);
		
		if(TCPCommunicator.getNextResponse()) {
			DriverStation.getInstance().toggleAutoButton();
		} else {
			System.out.println("Action failed!");
		}
	}
	
}
