# Push services for WeCom

## information

- Name: WeCom (a.k.a Qiyeweixin, 企业微信 in Chinese)
- Vendor: tencent
- Official Website: www.example.com

## Tips

- the WeCom webhook bot has a very limited markdown support, you can view the official docs for more detail
- the max character length of a single message is 5000, string that over this size will be split 

## How to use

Firstly you need to create a bot in your chat group, and get the web hook url of this bot, for more information please visit [the official documentation](https://developer.work.weixin.qq.com/document/path/91770) (in Chinese).

Then you need to connect Hibiki to your wework bot, here are two ways to do this:

### Method 1: using properties (TODO)

Specify this jvm properties to your app that using Hibiki:

```plaintext
hibiki.channels.<channel_name>.type=wecom
hibiki.channels.<channel_name>.webHookUrl=<your_web_hook_url_here>
```


