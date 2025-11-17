package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.DriveEncoderConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Tuning", group="Linear OpMode")
public class Constants {

    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(10)
            .forwardZeroPowerAcceleration(-12)    // was -10
            .lateralZeroPowerAcceleration(-12)    // was -10
            .useSecondaryTranslationalPIDF(false)
            .useSecondaryHeadingPIDF(false)
            .useSecondaryDrivePIDF(false)
            .centripetalScaling(0.00055)
            .translationalPIDFCoefficients(new PIDFCoefficients(0, 0, 0, 0))  // was 0.3, 0, 0.01, 0
            .headingPIDFCoefficients(new PIDFCoefficients(0, 0, 0, 0))  // was 5, 0, 0, 0
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.05, 0, 0, 0, 0));  // was 0.05, 0, 0, 0.6, 0


    public static MecanumConstants driveConstants = new MecanumConstants()
            .leftFrontMotorName("front_left_motor")
            .leftRearMotorName("back_left_motor")
            .rightFrontMotorName("front_right_motor")
            .rightRearMotorName("back_right_motor")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)

            .xVelocity(26.99)   // was 26.99
            .yVelocity(26.99)  // was 26.99
            .useBrakeModeInTeleOp(true);

    public static DriveEncoderConstants localizerConstants = new DriveEncoderConstants()
            .leftFrontMotorName("front_left_motor")
            .leftRearMotorName("back_left_motor")
            .rightFrontMotorName("front_right_motor")
            .rightRearMotorName("back_right_motor")
            .leftFrontEncoderDirection(Encoder.REVERSE)
            .leftRearEncoderDirection(Encoder.REVERSE)
            .rightFrontEncoderDirection(Encoder.FORWARD)
            .rightRearEncoderDirection(Encoder.FORWARD)
            .robotWidth(16.92)
            .robotLength(17.7)
            .forwardTicksToInches(0.00884)
            .strafeTicksToInches(0.01150)
            .turnTicksToInches(0.02380);



    public static PathConstraints pathConstraints = new PathConstraints(
            0.45,
            30,
            0.2,
            10);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .driveEncoderLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}
