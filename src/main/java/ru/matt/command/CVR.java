package ru.matt.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class CVR {

    private static float visualrationumber = 1.78f;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("visualratio")
                .then(CommandManager.argument("number", FloatArgumentType.floatArg())
                        .executes(context -> execute(context, FloatArgumentType.getFloat(context, "number")))));
    }

    private static int execute(CommandContext<ServerCommandSource> context, float number) {
        if (number < 0.1f || number > 5) {
            context.getSource().sendError(Text.of("Ошибка: Введенное число выходит за пределы диапазона от 0.1 до 5."));
            return 0;
        }
        visualrationumber = number;
        return 0;
    }
    public static float getVisualrationumber() {
        return visualrationumber;
    }
}