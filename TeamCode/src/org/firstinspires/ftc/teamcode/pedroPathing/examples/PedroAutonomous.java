package org.firstinspires.ftc.teamcode.pedroPathing.examples;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "Pedro Pathing Autonomous", group = "Autonomous")
public class PedroAutonomous extends OpMode {

    public Follower follower; // Pedro Pathing follower instance
    private int pathState; // Current autonomous path state (state machine)
    private Paths paths; // Paths defined in the Paths class

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);

        // Starting pose = início do Path1 (IMPORTANTÍSSIMO)
        follower.setStartingPose(new Pose(27.746, 132.624, Math.toRadians(143)));

        paths = new Paths(follower);
        pathState = 0;
    }

    @Override
    public void loop() {
        follower.update();

        switch (pathState) {

            case 0:
                follower.followPath(paths.Path1, true);
                pathState++;
                break;

            case 1:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path2, true);
                pathState++;
                break;

            case 2:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path3, true);
                pathState++;
                break;

            case 3:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path4, true);
                pathState++;
                break;

            case 4:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path5, true);
                pathState++;
                break;

            case 5:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path6, true);
                pathState++;
                break;

            case 6:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path7, true);
                pathState++;
                break;

            case 7:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path8, true);
                pathState++;
                break;

            case 8:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path9, true);
                pathState++;
                break;

            case 9:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path10, true);
                pathState++;
                break;

            case 10:
                if (follower.isBusy()) break;

                follower.followPath(paths.Path11, true);
                pathState++;
                break;

            case 11:
                // Fim
                break;
        }

        telemetry.addData("State", pathState);
        telemetry.addData("X", follower.getPose().getX());
        telemetry.addData("Y", follower.getPose().getY());
        telemetry.addData("Heading", follower.getPose().getHeading());
        telemetry.update();
    }

    public static class Paths {

        public PathChain Path1;
        public PathChain Path2;
        public PathChain Path3;
        public PathChain Path4;
        public PathChain Path5;
        public PathChain Path6;
        public PathChain Path7;
        public PathChain Path8;
        public PathChain Path9;
        public PathChain Path10;
        public PathChain Path11;

        public Paths(Follower follower) {
            Path1 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(27.746, 132.624), new Pose(52.162, 91.283))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(143), Math.toRadians(135))
                    .build();

            Path2 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(52.162, 91.283), new Pose(43.283, 84.069))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(135), Math.toRadians(180))
                    .build();

            Path3 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(43.283, 84.069), new Pose(15.260, 84.069))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .build();

            Path4 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(15.260, 84.069), new Pose(52.994, 90.173))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(135))
                    .build();

            Path5 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(52.994, 90.173), new Pose(43.006, 60.486))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(135), Math.toRadians(180))
                    .build();

            Path6 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(43.006, 60.486), new Pose(15.260, 60.300))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .build();

            Path7 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(15.260, 60.300), new Pose(53.827, 89.064))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(135))
                    .build();

            Path8 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(53.827, 89.064), new Pose(45.283, 36.000))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(135), Math.toRadians(180))
                    .build();

            Path9 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(45.283, 36.000), new Pose(15.260, 36.000))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .build();

            Path10 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(15.260, 36.000), new Pose(54.659, 88.231))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(135))
                    .build();

            Path11 = follower
                    .pathBuilder()
                    .addPath(
                            new BezierLine(new Pose(54.659, 88.231), new Pose(22.751, 71.861))
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(135), Math.toRadians(180))
                    .build();
        }
    }

    public int autonomousPathUpdate() {
        // Add your state machine Here
        // Access paths with paths.pathName
        // Refer to the Pedro Pathing Docs (Auto Example) for an example state machine
        return pathState;
    }
}