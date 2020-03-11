
import axios from 'axios';



var HttpRequest = {
  getRequest({ url, data = {}, method = "GET" }) {
    return new Promise((resolve, reject) => {
      this._getRequest(url, resolve, reject, data, method);
    });
  },
  _getRequest: function(url, resolve, reject, data = {}, method = "GET") {
    let format = method.toLocaleLowerCase() ==='get'?'params':'data';
    console.log(data)
    axios({
      url: url,
      method: method,
      [format]: data,
      header: {
        "content-type": "application/json"
      }
    }).then(res => {

      resolve(res);
    }).catch((err) => {
      console.log(err)

      // this.$Message.info({
      //   content: err,
      //   type: 'error',
      //   closable: true
      // });
    })
  }
};
export { HttpRequest };








export default function defaultFetch() {}


export async function fetch(options) {

  try {
    let instance = await axios.create({
      timeout: 20000, // 超时
      headers: {
        'Content-Type': 'application/json',
      },
    });
    let result = await instance(options);
    result = result.data;
    console.log(result);
    //if (result.code === 1200 || result.code === 2000) {
      return result;
    // } else {
    //   this.$Message.info({
    //     content: result.message,
    //     type: 'error',
    //     closable: true
    //   });
    // }
  } catch (err) {
    console.log(err)
  }
}
