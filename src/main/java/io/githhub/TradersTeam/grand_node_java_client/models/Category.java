package io.githhub.TradersTeam.grand_node_java_client.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Category {
    private String Id;
    private String Name;
    private String Description;
    private String BottomDescription;
    private String CategoryLayoutId;
    private String MetaKeywords;
    private String MetaDescription;
    private String MetaTitle;
    private String SeName;
    private String ParentCategoryId;
    private String PictureId;
    private int PageSize;
    private boolean AllowCustomersToSelectPageSize;
    private String PageSizeOptions;
    private boolean ShowOnHomePage;
    private boolean FeaturedProductsOnHomaPage;
    private boolean IncludeInTopMenu;
    private boolean Published;
    private int DisplayOrder;
    private String ExternalId;
    private String Flag;
    private String FlagStyle;
    private String Icon;
    private boolean HideOnCatalog;
    private boolean ShowOnSearchBox;
    private int SearchBoxDisplayOrder;
}
