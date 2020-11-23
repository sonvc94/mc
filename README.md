# MMS-integrate-for-merchant

example integrate for merchant

## Installation

```bash
java -jar *.jar
```
or
```docker
docker-compose up -d
```

## Usage


1. implement TransactionCore or modify TransactionImpl to integrate with Merchant System
2. write adapter to convert confirm request to merchant request and merchant response to confirm response 


## Example message
```json

{
  "code": "00",
  "message": "Tru tien thanh cong, so trace 100550",
  "msgType": "1",
  "txnId": "50141",
  "qrTrace": "000098469",
  "bankCode": "VIETCOMBANK",
  "mobile": "0989511021",
  "accountNo": "",
  "amount": "100000",
  "payDate": "20180807164732",
  "masterMerCode": "A000000775",
  "merchantCode": "0311609355",
  "terminalId": "FPT02",
  "addData": [{
    "merchantType": "5045",
    "serviceCode": "06",
    "masterMerCode": "A000000775",
    "merchantCode": "0311609355",
    "terminalId": "FPT02",
    "productId": "",
    "amount": "100000",
    "ccy": "704",
    "qty": "1",
    "note": ""
  }],
  "checksum": "46C49C88C6C28931A8F354E15B5BE9D3",
  "ccy": "704"
}
```
```json
{
    "code": "00",
    "message": "thanh cong",
    "data": {
        "txnId": "50141"
    }
}
```
