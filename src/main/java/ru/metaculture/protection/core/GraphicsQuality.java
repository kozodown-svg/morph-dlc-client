package ru.metaculture.protection;

public enum GraphicsQuality {
   LOW("Низкое"),
   MEDIUM("Баланс"),
   HIGH("Высокое"),
   ULTRA("Ультра");

   private final String text;

   private GraphicsQuality(String string2) {
      this.text = string2;
   }

   public String getText() {
      return this.text;
   }

   public static String[] resolve() {
      GraphicsQuality[] graphicsQualities = values();
      String[] texts = new String[graphicsQualities.length];

      for (int intValue = 0; intValue < graphicsQualities.length; intValue++) {
         texts[intValue] = graphicsQualities[intValue].text;
      }

      return texts;
   }

   public static GraphicsQuality resolve2(int i) {
      GraphicsQuality[] graphicsQualities2 = values();
      int intValue2 = Math.max(0, Math.min(graphicsQualities2.length - 1, i));
      return graphicsQualities2[intValue2];
   }

   public void invoke() {
      boolean flag = this == LOW;
      boolean flag2 = this == MEDIUM;
      boolean flag3 = this == HIGH;
      boolean flag4 = this == ULTRA;
      boolean flag5 = flag2 || flag3 || flag4;
      boolean flag6 = flag3 || flag4;
      MenuModule.VOLNY_KLIKA.setValue(flag5);
      MenuModule.VOLNY_TEMY.setValue(flag6);
      MenuModule.UDARNAYA_VOLNA_TEMY.setValue(flag4);
      MenuModule.RAZMYTIE_SKROLLA.setValue(flag6);
      MenuModule.PEREHODY_KART.setValue(flag5);
      MenuModule.PEREHODY_EKRANA.setValue(flag5);
      MenuModule.DREYF_TSVETA_TEMY.setValue(flag6);
      MenuModule.VNUTRENNEE_SVECHENIE.setValue(flag4);
      MenuModule.ZERNO_PLYONKI.setValue(flag6);
      MenuModule.PULSATSIYA_HOTBARA.setValue(flag5);
      MenuModule.ANIMATSII_STATUSOV.setValue(flag5);
      MenuModule.VSPYSHKA_URONA.setValue(flag5);
      MenuModule.PULSATSIYA_REGENERATSII.setValue(flag6);
      MenuModule.TRYASKA_PRI_NIZKOM_ZDOROVE.setValue(flag6);
      MenuModule.SLED_KURSORA_VMENYU.setValue(flag5);
      MenuModule.PARALLAKS_GLAVNOGO_MENYU.setValue(flag5);
      MenuModule.MAKSIMALNYY_BLYUR.invoke(flag ? 12.0F : (flag2 ? 26.0F : (flag3 ? 42.0F : 58.0F)));
      MenuModule.IRIDISTSENTNYY_OTLIV.invoke(flag ? 0.26F : (flag2 ? 0.46F : (flag3 ? 0.64F : 0.82F)));
      MenuModule.PRITYAZHENIE_KKURSORU.invoke(flag ? 0.06F : (flag2 ? 0.16F : (flag3 ? 0.27F : 0.36F)));
      MenuModule.RADIUS_PROZRACHNOSTI_UKURSORA.invoke(flag ? 0.18F : (flag2 ? 0.26F : (flag3 ? 0.36F : 0.48F)));
      MenuModule.RAZMER_OSTROVKOV.invoke(flag ? 1.05F : (flag2 ? 1.55F : (flag3 ? 2.15F : 2.8F)));
      MenuModule.SKOROST_TECHENIYA.invoke(flag ? 0.18F : (flag2 ? 0.46F : (flag3 ? 0.72F : 1.02F)));
      MenuModule.KONTRAST_OSTROVKOV.invoke(flag ? 0.32F : (flag2 ? 0.52F : (flag3 ? 0.68F : 0.82F)));
      MenuModule.VINETKA.invoke(flag ? 0.2F : (flag2 ? 0.34F : (flag3 ? 0.46F : 0.58F)));
      MenuModule.YARKOST.invoke(flag ? 0.48F : (flag2 ? 0.56F : (flag3 ? 0.62F : 0.7F)));
      MenuModule.NASYSCHENNOST.invoke(flag ? 0.32F : (flag2 ? 0.48F : (flag3 ? 0.62F : 0.78F)));
      MenuModule.OTKLYUCHIT_BLYUR.setValue(flag);
      MenuModule.UPROSCHYONNYE_TENI_HUD.setValue(flag || flag2);
      MenuModule.BYSTRYE_ANIMATSII.setValue(flag);
      MenuModule.PROPUSKAT_CHASTITSY_KLIENTA.setValue(flag);
   }
}
