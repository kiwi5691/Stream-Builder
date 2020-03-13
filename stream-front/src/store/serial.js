const serialStore = {
  state: {
    serialNum:'',//序列码
  },
  mutations: {
    setSerialNum(serialNum) {
      state.serialNum = serialNum
    }

  }
}

export default serialStore
