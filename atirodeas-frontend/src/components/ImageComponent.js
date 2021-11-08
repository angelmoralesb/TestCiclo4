import React, { Component  } from 'react';


class Image extends Component{


  render() {
    return(
      /*Mostramos la imagen que nos viene del componente padre, en la etiqueta*/
      <img src={this.props.src}  alt="Fotografia" width="100px" height="100px"/>
    )
  }
}

export default Image;