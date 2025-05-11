package ru.harimasa.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.harimasa.config.ConfigScreen;


@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

	@Shadow
	private float zoom;

	@Shadow
	private float zoomX;

	@Shadow
	private float zoomY;

	@Shadow
	private float viewDistance;

	@Inject(method = "getBasicProjectionMatrix", at = @At("TAIL"), cancellable = true)
	public void getBasicProjectionMatrixHook(float fov, CallbackInfoReturnable<Matrix4f> cir) {
		if (ConfigScreen.CONFIG.instance().enable) {
			MatrixStack matrixStack = new MatrixStack();
			matrixStack.peek().getPositionMatrix().identity();
			if (zoom != 1.0f) {
				matrixStack.translate(zoomX, -zoomY, 0.0f);
				matrixStack.scale(zoom, zoom, 1.0f);
			}
			matrixStack.peek().getPositionMatrix().mul(new Matrix4f().setPerspective((float) (fov * 0.01745329238474369), ConfigScreen.CONFIG.instance().value, 0.05f, viewDistance * 4.0f));
			cir.setReturnValue(matrixStack.peek().getPositionMatrix());
		}
	}
}