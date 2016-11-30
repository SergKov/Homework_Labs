package laba1.view;

import laba1.appliances.AbstractAppliance;

import java.util.List;

/**
 * Created by koval on 29.11.2016.
 */
public interface View {

    void print(List<AbstractAppliance> list);

    void print(AbstractAppliance appliance);
}
