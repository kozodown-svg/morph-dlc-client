package ru.metaculture.protection;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;

public final class ClickGuiEventBridge {
   private static volatile boolean flag = false;

   private ClickGuiEventBridge() {
   }

   public static void invoke() {
      if (!flag) {
         flag = true;
         EventManager.register(
            new Object() {
               @EventHandler
               public void onHudFrame(HudFrameEvent hudFrameEvent) {
                  MinecraftClient client = hudFrameEvent.getClient();
                  if (client != null) {
                     if (client.currentScreen instanceof ClickGuiScreen) {
                        if (ClickGuiEventBridge.check(client)) {
                           double[] doubleValues = new double[1];
                           double[] doubleValues2 = new double[1];
                           if (client.getWindow() != null) {
                              GLFW.glfwGetCursorPos(client.getWindow().getHandle(), doubleValues, doubleValues2);
                              if (client.mouse != null) {
                                 client.mouse.unlockCursor();
                              }
                           }

                           BlurRenderer blurRenderer = BlurRenderer.getINSTANCE();
                           boolean flag = blurRenderer.check(client.currentScreen)
                              && blurRenderer.check3(client.getWindow().getFramebufferWidth(), client.getWindow().getFramebufferHeight());

                           try {
                              LegacyClickGuiRenderer.invoke(
                                 hudFrameEvent.getRenderManager(), null, (int)doubleValues[0], (int)doubleValues2[0], client.getRenderTickCounter().getDynamicDeltaTicks()
                              );
                              hudFrameEvent.getRenderManager().invoke20();
                           } finally {
                              if (flag) {
                                 blurRenderer.invoke5();
                              }
                           }
                        }
                     }
                  }
               }

               @EventHandler
               public void onHudFrame(HudRenderEvent hudRenderEvent) {
                  MinecraftClient client2 = hudRenderEvent.getClient();
                  if (client2 != null) {
                     if (client2.currentScreen instanceof ModernClickGuiScreen modernClickGuiScreen) {
                        modernClickGuiScreen.invoke(
                           hudRenderEvent.getRenderManager(),
                           hudRenderEvent.getDrawContext(),
                           hudRenderEvent.getIntValue(),
                           hudRenderEvent.getIntValue2(),
                           client2.getRenderTickCounter().getDynamicDeltaTicks()
                        );
                     }
                  }
               }
            }
         );
      }
   }

   static boolean check(MinecraftClient minecraftClient) {
      if (minecraftClient != null && minecraftClient.getWindow() != null) {
         Window window = minecraftClient.getWindow();
         return !window.hasZeroWidthOrHeight() && window.getFramebufferWidth() > 0 && window.getFramebufferHeight() > 0;
      } else {
         return false;
      }
   }
}
