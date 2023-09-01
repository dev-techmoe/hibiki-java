# hibiki

## This project is under development

No any stable version released, API may change in the future, do not use in production now.

## What's hibiki

Hibiki is a library that enables easy message delivery to various platforms, such as WeCom (also known as Qiyeweixin or 企业微信 in Chinese), DingTalk (钉钉 in Chinese), Telegram, and more.

Hibiki provides a unified interface for the APIs of different platforms, allowing you to use any of the built-in platforms with ease.

## What's NOT hibiki

- Hibiki is a wrapper for the message sending APIs of various platforms. It does not have any other capabilities, such as receiving or handling messages.
- The purpose of this library is to send some maintenance alerts to the author’s chat group in the company. It does not have any more complex features for handling or routing messages, etc.

## Installation

JDK 1.8 or above is required.

TODO

## Quickstart

TODO

## Spring boot starter

TODO

## Supported push services

| name         | status | description                                                           |
|--------------|--------|-----------------------------------------------------------------------|
| WeCom(企业微信)  | OK     | [source](hibiki-core/src/main/moe/tty/hibiki/core/pushservices/wecom) |
| DingTalk(钉钉) | WIP    |                                                                       |
| Telegram     | WIP    |                                                                       |
| OneBot v11   | WIP    |                                                                       |
| Slack        | WIP    |                                                                       |
| Discord      | WIP    |                                                                       |
| stdout       | OK     | print messages to stdout, just for testing                            |

Please let me know if you need any other platform that is not in the list :)

## License

MIT
