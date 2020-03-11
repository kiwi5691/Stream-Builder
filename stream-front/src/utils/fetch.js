
import axios from 'axios';

export default function defaultFetch() {}

export async function fetch(options) {

  try {
    let instance = await axios.create({
      timeout: 20000, // 超时
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
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
