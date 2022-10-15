import React from "react";
import { withNavigation } from "../../routeconf";

class AddProduct extends React.Component{

    constructor(props){
        super(props);

        this.state={
            name: "",
            duration: 0,
            showSelectCategory: false,
            selectedCategory: [],
        };

        this.create = this.create.bin(this);
        this.handleCategorySelection = this.handleCategorySelection.bind(this);
    }

    handleGenresSelection(selectedCategory){
        this.setState({selectedCategory: selectedCategory})
    }

    create(){
        var params={
            
        }
    }


}

export default withNavigation(AddProduct);