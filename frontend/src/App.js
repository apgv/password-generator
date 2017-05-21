import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import {Button, Glyphicon} from 'react-bootstrap';
import CopyToClipboard from "react-copy-to-clipboard";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            password: '',
            pendingRequest: false,
            copied: false
        };

        this.fetchPassword = this.fetchPassword.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.onCopy = this.onCopy.bind(this);
    }

    componentDidMount() {
        this.fetchPassword();
    }

    fetchPassword() {
        this.setState({pendingRequest: true});

        fetch('/password')
            .then(response => response.json())
            .then(result => {
                    this.setState({
                        password: result.join(''),
                        pendingRequest: false,
                        copied: false
                    });
                }
            );
    }

    handleChange(event) {
        this.setState({password: event.target.value, copied: false});
    }

    onCopy() {
        this.setState({copied: true});
    }

    render() {
        const divStyle = {marginTop: 10};
        const passwordMargin = {marginRight: 2};
        const copyButtonMargin = {marginRight: 10};

        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Generate password</h2>
                </div>
                <div style={divStyle}>
                    <input
                        value={this.state.password}
                        onChange={this.handleChange}
                        style={passwordMargin}
                    />
                    <CopyToClipboard
                        text={this.state.password}
                        onCopy={this.onCopy}
                        style={copyButtonMargin}>
                        <Button bsSize="small">
                            <Glyphicon glyph="copy"/>
                        </Button>
                    </CopyToClipboard>
                    <Button
                        onClick={this.fetchPassword}
                        disabled={this.state.pendingRequest}>
                        <Glyphicon glyph="refresh"/>
                    </Button>
                </div>
            </div>
        );
    }
}

export default App;
