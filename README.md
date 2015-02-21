# EV3arbitrator
Program in LeJOS for Lego Mindstorms EV3 - working with the Arbitrator class

//README DRAFT Feb 21

//Objective:
1.If it is backing up and it hits something according to the touch sensor then it moves forward.
2.If it is near a bright light then it backs up. You can choose the threshold when it starts to back up. A flashlight is useful for testing but turning on/off lights can work.
3. The closer it gets to something while moving forward the slower it goes. This means the speed is related to how far away the ultrasonic sensor sees something. If it gets too close then it turns. Testing may help you decide at what point actions should happen. By default it does this behavior (if the other two sensors are not causing other behavior). You are allowed to complete a turn before you go back to check the other sensors.

The order list is the order that actions occur. This means that if the touch sensor is pushed it goes forward even if it is bright light or near something. If the touch sensor is not active and it sees a bright light then it backs up. If neither is the case then it uses its distance to whatever is in front of it to move per step 3.
