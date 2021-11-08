import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark header">
                    <div className="navbar-brand">Comercializadora A tiro de as Management App</div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
