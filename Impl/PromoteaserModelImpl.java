package com.ttnretail.core.models.impl;

import com.adobe.cq.commerce.core.components.services.urls.UrlProvider;
import com.day.cq.wcm.api.Page;
import com.ttnretail.core.models.PromoTeaserData;
import com.ttnretail.core.models.PromoteaserModel;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;


import java.util.List;



@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = PromoteaserModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PromoteaserModelImpl implements PromoteaserModel {



    PromoTeaserDataImpl  promoTeaserDataImpl = new PromoTeaserDataImpl() ;
    @OSGiService
    private UrlProvider urlProvider;

    @ScriptVariable
    private Page currentPage;

    @Self
    private SlingHttpServletRequest request;

    @ChildResource(name = "promoteaserdetails")
    List<PromoTeaserData> promoteaserdetails;

    String actionPath;



    @Override
    public List<PromoTeaserData> getPromoTeaser() {
        for(PromoTeaserData id : promoteaserdetails )
        {
            actionPath = urlProvider.toCategoryUrl(request, currentPage, id.getCategoryId());
            promoTeaserDataImpl.setActionUrl(actionPath);
        }
        return promoteaserdetails;
    }
}
