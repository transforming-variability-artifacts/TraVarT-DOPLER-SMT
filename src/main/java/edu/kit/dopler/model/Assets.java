/**
 * This class represents the assets of the DOPLER model
 * Assets represent solution space artifacts available in a product line
 * The assets are linked to a decision via an inclusionCondition
 *
 */


package edu.kit.dopler.model;

import java.util.Collections;
import java.util.Set;

public class Assets {

    public Assets(String description, IExpression inclusionCondition){
        this.description = description;
        this.inclusionCondition = inclusionCondition;
    }


    private String description;
    private IExpression inclusionCondition;
    private Set<Assets> assets = Collections.emptySet();

    void setDescription(String description){
        this.description = description;
    }

    String getDescription(){
        return description;
    }

    public void setInclusionCondition(IExpression inclusionCondition) {
        this.inclusionCondition = inclusionCondition;
    }

    IExpression getInclusionCondition(){
        return inclusionCondition;
    }

    public Set<Assets> getAssets() {
        return assets;
    }

    public void setAssets(Set<Assets> assets) {
        this.assets = assets;
    }

}
