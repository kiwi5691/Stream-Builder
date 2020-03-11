import { fetch } from "../utils/fetch";
import qs from 'qs';


export function construct(baseClass) {
  return fetch({
    /*url与后台映射地址匹配;  method 与映射的方法匹配-->包括 GetMapping PostMapping
     *    PutMapping  DeleteMapping 等注解方法
     */
    url: 'api/constructClass',
    method: 'post',
    data: qs.stringify(baseClass),
  });
}


export function findIndoorMapByMapId(mapId) {
  return fetch({
    url: `/ax/indoorMaps/${mapId}`,
    method: 'post',
  });
}


export function findIndoorMapById(id) {
  return fetch({
    url: `/ax/indoorMapsIds/${id}`,
    method: 'get',
  });
}

/**
 * 添加
 */
export function insertIndoorMap(indoorMap) {
  return fetch({
    url: '/ax/indoorMaps',
    method: 'post',
    data: qs.stringify(indoorMap),
  });
}

/**
 * 更新
 */
export function updateIndoorMap(indoorMap) {
  return fetch({
    url: '/api/indoorMaps',
    method: 'put',
    data: qs.stringify(indoorMap),
  });
}
