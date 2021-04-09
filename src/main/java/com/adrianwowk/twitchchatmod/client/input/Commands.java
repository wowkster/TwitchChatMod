package com.adrianwowk.twitchchatmod.client.input;

import com.adrianwowk.twitchchatmod.client.input.commands.*;

public class Commands {
    public static final InputCommand FORWARD = new ForwardCommand();
    public static final InputCommand BACKWARD = new BackwardCommand();
    public static final InputCommand LEFT = new LeftStrafeCommand();
    public static final InputCommand RIGHT = new RightStrafeCommand();
    public static final InputCommand JUMP = new JumpCommand();
    public static final InputCommand PLACE = new PlaceCommand();
    public static final InputCommand ATTACK = new AttackCommand();
    public static final InputCommand USE = new UseCommand();
    public static final InputCommand DESTROY = new DestroyCommand();
}
