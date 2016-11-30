package laba1.view;

import laba1.appliances.AbstractAppliance;

import java.util.List;

/**
 * Created by koval on 29.11.2016.
 */
public class Console implements View {

    @Override
    public void print(final List<AbstractAppliance> appliances) {
        appliances.forEach(System.out::println);
    }

    @Override
    public void print(AbstractAppliance appliance) {
        System.out.println(appliance);
    }
}
