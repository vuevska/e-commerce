import './App.css';
import {Component} from "react";
import Manufacturers from "../Manufacturers/manufacturers";
import EShopService from "../../repository/eshopRepository";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            manufacturers: []
        }
    }

    render() {
        return (
            <div>
                <Manufacturers manufacturers={this.state.manufacturers}>
                </Manufacturers>
            </div>
        );
    }

    loadManufacturers = () => {
        EShopService.fetchManufacturers()
            .then((data) => {
                this.setState({
                    manufacturers : data.data
                })
            });
    }

    componentDidMount() {
    }
}

export default App;
