package io.githhub.TradersTeam.grand_node_java_client.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Collection {
    private String Name;
    private String SeName;
    private String Description;
    private String BottomDescription;
    private String CollectionLayoutId;
    private String MetaKeywords;
    private String MetaDescription;
    private String MetaTitle;
    private String PictureId;
    private int PageSize;
    private boolean AllowCustomersToSelectPageSize;
    private String PageSizeOptions;
    private boolean ShowOnHomePage;
    private boolean FeaturedProductsOnHomePage;
    private boolean IncludeInMenu;
    private String Icon;
    private boolean Published;
    private String ExternalId;
    private boolean DisplayOrder;
}
