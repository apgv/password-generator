import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {password: '', pendingRequest: false};

        this.fetchPassword = this.fetchPassword.bind(this);
    }

    componentDidMount() {
        this.fetchPassword();
    }

    fetchPassword() {
        this.setState({pendingRequest: true});

        fetch('/password')
            .then(response => response.json())
            .then(result => {
                    this.setState({password: result.join(''), pendingRequest: false})
                }
            );
    }

    render() {
        const divStyle = {marginTop: 10};
        const buttonStyle = {marginLeft: 10};

        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Generate password</h2>
                </div>
                <div style={divStyle}>
                    Password: {this.state.password}
                    <button
                        onClick={this.fetchPassword}
                        disabled={this.state.pendingRequest}
                        style={buttonStyle}>
                        New password
                    </button>
                </div>
            </div>
        );
    }
}

export default App;
