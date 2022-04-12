#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class DomainProduct, DomainProductsManager, DomainKotlinThrowable, DomainKotlinArray<T>, DomainKotlinException, DomainKotlinRuntimeException, DomainKotlinIllegalStateException, DomainKotlinUnit;

@protocol DomainKotlinCoroutineContext, DomainKotlinx_coroutines_coreCoroutineScope, DomainKotlinx_coroutines_coreStateFlow, DomainKotlinCoroutineContextElement, DomainKotlinCoroutineContextKey, DomainKotlinx_coroutines_coreFlowCollector, DomainKotlinx_coroutines_coreFlow, DomainKotlinx_coroutines_coreSharedFlow, DomainKotlinIterator;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface DomainBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface DomainBase (DomainBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface DomainMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface DomainMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorDomainKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface DomainNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface DomainByte : DomainNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface DomainUByte : DomainNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface DomainShort : DomainNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface DomainUShort : DomainNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface DomainInt : DomainNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface DomainUInt : DomainNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface DomainLong : DomainNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface DomainULong : DomainNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface DomainFloat : DomainNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface DomainDouble : DomainNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface DomainBoolean : DomainNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Greeting")))
@interface DomainGreeting : DomainBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getHtmlWithCompletionHandler:(void (^)(NSString * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getHtml(completionHandler:)")));
- (NSString *)greeting __attribute__((swift_name("greeting()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform")))
@interface DomainPlatform : DomainBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (readonly) NSString *platform __attribute__((swift_name("platform")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Product")))
@interface DomainProduct : DomainBase
- (instancetype)initWithSku:(NSString *)sku price:(int64_t)price imageUrl:(NSString *)imageUrl __attribute__((swift_name("init(sku:price:imageUrl:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (int64_t)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (DomainProduct *)doCopySku:(NSString *)sku price:(int64_t)price imageUrl:(NSString *)imageUrl __attribute__((swift_name("doCopy(sku:price:imageUrl:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *imageUrl __attribute__((swift_name("imageUrl")));
@property (readonly) int64_t price __attribute__((swift_name("price")));
@property (readonly) NSString *sku __attribute__((swift_name("sku")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol DomainKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<DomainKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProductsManager")))
@interface DomainProductsManager : DomainBase <DomainKotlinx_coroutines_coreCoroutineScope>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)productsManager __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) DomainProductsManager *shared __attribute__((swift_name("shared")));
- (id<DomainKotlinx_coroutines_coreStateFlow>)getProductsFlow __attribute__((swift_name("getProductsFlow()")));
- (void)searchText:(NSString *)text __attribute__((swift_name("search(text:)")));
@property (readonly) id<DomainKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ProductsManagerKt")))
@interface DomainProductsManagerKt : DomainBase
@property (class, readonly) NSArray<DomainProduct *> *fake __attribute__((swift_name("fake")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface DomainKotlinThrowable : DomainBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (DomainKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) DomainKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end;

__attribute__((swift_name("KotlinException")))
@interface DomainKotlinException : DomainKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface DomainKotlinRuntimeException : DomainKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface DomainKotlinIllegalStateException : DomainKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface DomainKotlinCancellationException : DomainKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(DomainKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol DomainKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<DomainKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<DomainKotlinCoroutineContextElement> _Nullable)getKey:(id<DomainKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<DomainKotlinCoroutineContext>)minusKeyKey:(id<DomainKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<DomainKotlinCoroutineContext>)plusContext:(id<DomainKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol DomainKotlinx_coroutines_coreFlow
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<DomainKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(DomainKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreSharedFlow")))
@protocol DomainKotlinx_coroutines_coreSharedFlow <DomainKotlinx_coroutines_coreFlow>
@required
@property (readonly) NSArray<id> *replayCache __attribute__((swift_name("replayCache")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreStateFlow")))
@protocol DomainKotlinx_coroutines_coreStateFlow <DomainKotlinx_coroutines_coreSharedFlow>
@required
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface DomainKotlinArray<T> : DomainBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(DomainInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<DomainKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol DomainKotlinCoroutineContextElement <DomainKotlinCoroutineContext>
@required
@property (readonly) id<DomainKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol DomainKotlinCoroutineContextKey
@required
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol DomainKotlinx_coroutines_coreFlowCollector
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(DomainKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface DomainKotlinUnit : DomainBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) DomainKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol DomainKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
