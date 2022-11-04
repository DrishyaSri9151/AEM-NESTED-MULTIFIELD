package com.ttnretail.core.models.impl;


import com.ttnretail.core.models.BrandImagesModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = {Resource.class},
         adapters = BrandImagesModel.class ,
          defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BrandImagesModelImpl implements BrandImagesModel {


    @ValueMapValue
    public List<String> brandText;

    @ValueMapValue
    public String title;

    @ValueMapValue
    public String backgroundimages;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getBrandImages() {
         if (brandText != null) {
            return new ArrayList<>(brandText);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public String getBackgroundImages() {
        return backgroundimages;
    }
}
